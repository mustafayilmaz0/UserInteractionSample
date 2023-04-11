package com.mustafayilmaz.userinteractionsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.snackbar.Snackbar
import com.mustafayilmaz.userinteractionsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//Todo: Spinner
        val languages = resources.getStringArray(R.array.languages)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long){

                Toast.makeText(applicationContext,getString(R.string.selected_item) + " " +"" + languages[position],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

// TODO: Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(applicationContext, "Merhaba", Toast.LENGTH_SHORT).show()
        }

        binding.btnOzelToast.setOnClickListener {

            val design = layoutInflater.inflate(R.layout.activity_toast, null)
            val tvMesaj = design.findViewById(R.id.textViewMesaj) as TextView

            tvMesaj.text = "İyi Tatiller"

            val toastOzel = Toast(applicationContext)

            toastOzel.view = design
            toastOzel.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)
            toastOzel.duration = Toast.LENGTH_SHORT
            toastOzel.show()
        }
// TODO: Menu

        binding.btnMenuAc.setOnClickListener {

            val popup = android.widget.PopupMenu(applicationContext, binding.btnMenuAc)

            popup.menuInflater.inflate(R.menu.popup_menu, popup.menu)

            popup.setOnMenuItemClickListener { i ->

                when (i.itemId) {
                    R.id.action_sil -> {
                        Toast.makeText(applicationContext, "Sil seçildi", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_duzenle -> {
                        Toast.makeText(applicationContext, "Düzenle seçildi", Toast.LENGTH_SHORT)
                            .show()
                        true
                    }
                    R.id.action_kaydet -> {
                        Toast.makeText(applicationContext, "Kaydet seçildi", Toast.LENGTH_SHORT)
                            .show()
                        true
                    }
                    R.id.action_cikis -> {
                        Toast.makeText(applicationContext, "Çıkış seçildi", Toast.LENGTH_SHORT)
                            .show()
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }
// TODO: Alert

        binding.btnAlert.setOnClickListener {

            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.img_toast)

            ad.setPositiveButton("Tamam") { dialogInterface, i ->

                Toast.makeText(applicationContext, "Tamam Tıklanıldı", Toast.LENGTH_SHORT).show()

            }
            ad.setNegativeButton("İptal") { dialogInterface, i ->

                Toast.makeText(applicationContext, "İptal Tıklanıldı", Toast.LENGTH_SHORT).show()
            }

            ad.create().show()
        }

        binding.btnOzelAlert.setOnClickListener {

            val tasarim = layoutInflater.inflate(R.layout.activity_alert, null)
            val editTextAlert = tasarim.findViewById(R.id.editTextAlert) as EditText
            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Mesaj")
            ad.setTitle("Başlık")
            ad.setIcon(R.drawable.img_toast)
            ad.setView(tasarim)
            ad.setPositiveButton("Kaydet") { dialogInterface, i ->

                val alinanVeri = editTextAlert.text.toString()

                Toast.makeText(applicationContext, "Alınan Veri : $alinanVeri", Toast.LENGTH_SHORT)
                    .show()
            }
            ad.setNegativeButton("İptal") { dialogInterface, i ->

                Toast.makeText(applicationContext, "İptal Tıklanıldı", Toast.LENGTH_SHORT).show()
            }
            ad.create().show()
        }
// TODO: SnackBar
        binding.btnSnackbar.setOnClickListener { nesne ->

            Snackbar.make(nesne, "Merhaba", Snackbar.LENGTH_SHORT).show()

        }

        binding.btnGeriDonusSnackbar.setOnClickListener { x ->

            Snackbar.make(x, "Mesaj Silinsin mi ? ", Snackbar.LENGTH_SHORT)
                .setAction("EVET") { y ->

                    Snackbar.make(y, "Mesaj Silindi", Snackbar.LENGTH_SHORT).show()

                }
                .show()
        }

        binding.btnOzelSnackbar.setOnClickListener { z ->

            val sb = Snackbar.make(z, "İnternet Bağlantısı Yok!", Snackbar.LENGTH_LONG)

            sb.setAction("Tekrar Dene") {

            }

            sb.setActionTextColor(Color.RED)
            sb.setTextColor(Color.BLUE)
            sb.setBackgroundTint(Color.WHITE)

            sb.show()
        }
// TODO: Dark mode

        binding.btnLightMode.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }

        binding.btnDarkMode.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        }

    }
}

