package com.gmail.mtec.sistemas.businesscard.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import com.gmail.mtec.sistemas.businesscard.R
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class ScreenShotCardForShare {

    companion object {
        fun share(context: Context, card: View) {
            val bitmap = getScreenShotCard(card)

            bitmap?.let {
                saveMediaToStorage(context, it)
            }
        }


        private fun getScreenShotCard(card: View): Bitmap? {
            var screenShot: Bitmap? = null
            try {
                screenShot = Bitmap.createBitmap(
                    card.measuredWidth,
                    card.measuredHeight,
                    Bitmap.Config.ARGB_8888
                )

                val canvas = Canvas(screenShot)
                card.draw(canvas)

            } catch (e: Exception) {
                Log.e("Erro ->", "Erro ao capturar imagem")
            }

            return screenShot
        }

        private fun saveMediaToStorage(context: Context, bitmap: Bitmap) {
            val fileName = "${System.currentTimeMillis()}.jpeg"

            var fos: OutputStream? = null

            //Verificar versao do android para salvar(cada versao do android existe uma permissao diferente para deixae salvar)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                context.contentResolver?.also { resolver ->
                    val contentValues = ContentValues().apply {
                        put(MediaStore.MediaColumns.DISPLAY_NAME, fileName)
                        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                        put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                    }

                    val imageUri: Uri? =
                        resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

                    fos = imageUri?.let {
                        shareIntent(context, imageUri)
                        resolver.openOutputStream(it)
                    }
                }


            } else {
                //Devices Rodando  Versions < Version Q
                val imageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val imageFile = File(imageDir, fileName)
                shareIntent(context, Uri.fromFile(imageFile))
                fos = FileOutputStream(imageFile)
            }

            //comprimir imagem para salvar no disco
            fos?.use {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
                Toast.makeText(context, context.getString(R.string.share), Toast.LENGTH_SHORT)
                    .show()
            }


        }

        private fun shareIntent(context: Context, imageUri: Uri) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, imageUri)
                type = "image/jpeg"
            }
            context.startActivity(
                Intent.createChooser(
                    shareIntent,
                    context.resources.getText(R.string.share)
                )
            )


        }

    }


}