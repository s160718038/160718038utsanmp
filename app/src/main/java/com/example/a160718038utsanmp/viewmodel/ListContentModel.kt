package com.example.a160718038utsanmp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160718038utsanmp.model.Content
import com.google.gson.Gson

class ListContentModel: ViewModel() {
    val contents = MutableLiveData<ArrayList<Content>>()

    fun refresh() {
        var gson = Gson()
        val json1 = "{\n" +
                "      \"id\": 1,\n" +
                "      \"username\": \"hendra\",\n" +
                "      \"image\": \"https://imgcdnblog.carbay.com/wp-content/uploads/2015/06/26075015/ferrari.jpg\",\n" +
                "      \"judul\": \"Ferrari 488 GTB: Mempersembahkan Performa dan Keindahan yang Mengagumkan\",\n" +
                "      \"des\": \"Ferrari 488 GTB adalah simbol kecepatan dan keindahan dalam satu paket. Dari desain aerodinamisnya hingga mesin bertenaga yang luar biasa, mobil ini menggabungkan keunggulan teknologi dengan keindahan estetika Italia.\",\n" +
                "      \"paragraf\": \"Dengan mesin V8 twin-turbocharged yang menghasilkan lebih dari 660 horsepower, Ferrari 488 GTB mampu melesat dari 0 hingga 100 km/jam dalam waktu kurang dari 3 detik. Namun, kecepatan bukanlah satu-satunya keistimewaan mobil ini. Desainnya yang elegan dan aerodinamis membantu mobil menjelajahi jalanan dengan gaya dan presisi yang luar biasa. Dari lingkarannya yang agresif hingga spoiler belakang yang diperbarui, setiap detail dari Ferrari 488 GTB dirancang untuk memaksimalkan performa dan keindahan.\",\n" +
                "      \"time\": \"2024-04-21\"\n" +
                "    }"
        val json2 = "{\n" +
                "      \"id\": 2,\n" +
                "      \"username\": \"dami\",\n" +
                "      \"image\": \"https://cdn.motor1.com/images/mgl/vxxvy6/s3/2023-porsche-911-gt3-rs-teaser-image.jpg\",\n" +
                "      \"judul\": \"Porsche 911 GT3 RS: Menghadirkan Pengalaman Balap yang Tanpa Kompromi\",\n" +
                "      \"des\": \"Porsche 911 GT3 RS adalah mobil yang dirancang untuk menghadirkan pengalaman balap tanpa kompromi. Dari teknologi balapnya yang canggih hingga desain aerodinamis yang dipoles, mobil ini membawa performa dan keandalan Porsche ke level yang baru.\",\n" +
                "      \"paragraf\": \"Ditenagai oleh mesin boxer enam-silinder yang menghasilkan lebih dari 500 horsepower, Porsche 911 GT3 RS mempercepat dari 0 hingga 100 km/jam dalam hitungan detik. Namun, mobil ini bukan hanya tentang kecepatan. Sasis yang dioptimalkan untuk lintasan balap, sistem suspensi yang disempurnakan, dan kontrol traksi yang canggih membuat Porsche 911 GT3 RS menjadi pilihan utama bagi para penggemar balap yang mencari kinerja yang luar biasa.\",\n" +
                "      \"time\": \"2024-04-21\"\n" +
                "    }"
        val json3 = "{\n" +
                "      \"id\": 3,\n" +
                "      \"username\": \"lilian\",\n" +
                "      \"image\": \"https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/masterpieces/huracan_performante/s/huracan_performante_s_01_m.jpg\",\n" +
                "      \"judul\": \"Lamborghini Huracan Performante: Memadukan Keindahan dan Teknologi Balap\",\n" +
                "      \"des\": \"Lamborghini Huracan Performante adalah inkarnasi kecepatan dan keindahan dalam bentuknya yang paling murni. Dari desainnya yang futuristik hingga teknologi balap terkini yang diimplementasikan, mobil ini menghadirkan pengalaman mengemudi yang tak tertandingi.\",\n" +
                "      \"paragraf\": \"Dilengkapi dengan mesin V10 yang menghasilkan lebih dari 600 horsepower, Lamborghini Huracan Performante adalah salah satu mobil sport paling kuat di jalanan. Namun, kekuatan tidaklah cukup. Mobil ini juga dilengkapi dengan sistem aerodinamis aktif, kontrol traksi yang disempurnakan, dan sistem penggerak semua roda yang membuatnya begitu mudah dikendalikan bahkan pada kecepatan tertinggi. Lamborghini Huracan Performante adalah manifestasi sempurna dari keindahan Italia dan keunggulan teknologi balap.\",\n" +
                "      \"time\": \"2024-04-21\"\n" +
                "    }"

        var content1 = gson.fromJson(json1, Content::class.java)
        var content2 = gson.fromJson(json2, Content::class.java)
        var content3 = gson.fromJson(json3, Content::class.java)
        contents.value = arrayListOf(content1, content2, content3)
    }
}