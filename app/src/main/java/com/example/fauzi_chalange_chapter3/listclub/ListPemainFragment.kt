package com.example.fauzi_chalange_chapter3.listclub
import PemainAdapter
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fauzi_chalange_chapter3.databinding.FragmentListBinding
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterpemain.PemainAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.data.Pemain


class ListPemainFragment : Fragment(), PemainAdapterListener {

    private lateinit var binding: FragmentListBinding
    private val pemainAdapter = PemainAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView(view.context)
        pemainAdapter.submitList(pemainData())

    }

    private fun getNama(): String {
        return getArgs().nama
    }

    private fun getArgs(): ListPemainFragmentArgs{
        return ListPemainFragmentArgs.fromBundle(arguments as Bundle)
    }

    private fun setupRecyclerView(context: Context) {
        binding.recyclerView.adapter = pemainAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
    }

    override fun onClickPemain(data: Pemain) {
         searchPemain(data)
    }

    private fun searchPemain(data: Pemain) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.transfermarkt.co.id/schnellsuche/ergebnis/schnellsuche?query=${data.nama}"))
        startActivity(intent)
    }

    private fun pemainData(): List<Pemain> {
        when(getNama()) {
            "Bali United" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/header/561250-1703148217.png",
                        nama = "Irfan Jaya",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/48765-1703148381.png",
                        nama = "Ilija Spasojević",
                        posisi = "Depan-Tengah",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/506449-1703142910.png",
                        nama = "Ricky Fajrin",
                        posisi = "Bek-Kiri",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/183945-1703147326.png",
                        nama = "Éber Bessa",
                        posisi = "Gel. Serang",
                        negara = "Brazil",
                    ),
                )
            }
            "Persija" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/323470-1634793503.jpg",
                        nama = "Andritany ",
                        posisi = "Kiper",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/734648-1704756277.jpg",
                        nama = "Rizky Ridho",
                        posisi = "Bek-Tengah",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/505793-1634793607.jpg",
                        nama = "Riko Simanjuntak",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/46650-1677230554.jpg",
                        nama = "Marko Simic",
                        posisi = "Depan-Tengah",
                        negara = "Kroasia",
                    ),
                )
            }
            "PSIS" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/473377-1699937213.jpeg",
                        nama = "Evan Dimas",
                        posisi = "Gel. Tengah",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/649447-1699780983.jpg",
                        nama = "Taisei Marukawa",
                        posisi = "Sayap Kiri",
                        negara = "Jepang",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/678002-1689561068.jpeg",
                        nama = "Paulo Gali",
                        posisi = "Sayap Kanan",
                        negara = "Timor Leste",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/719822-1615953493.jpg",
                        nama = "Wahyu Prasetyo",
                        posisi = "Bek-Tengah",
                        negara = "Indonesia",
                    ),
                )
            }
            "Persib" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/474524-1615689570.jpg",
                        nama = "Teja Paku Alam",
                        posisi = "Kiper",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/559358-1699722504.png",
                        nama = "Rachmat Irianto",
                        posisi = "Gel. Bertahan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/190933-1699723302.png",
                        nama = "David da Silva",
                        posisi = "Depan-Tengah",
                        negara = "Brazil",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/506019-1615692423.jpg",
                        nama = "Febri Hariyadi",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                )
            }
            "Persebaya" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/734647-1640664925.jpg",
                        nama = "Ernando Ari ",
                        posisi = "Kiper",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/561246-1640765760.jpg",
                        nama = "Oktafianus Fernando",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/818005-1637572014.jpg",
                        nama = "Andre Oktaviansyah",
                        posisi = "Gel. Bertahan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/873410-1636249659.jpg",
                        nama = "Andhika Ramadhani",
                        posisi = "Kiper",
                        negara = "Indonesia",
                    ),
                )
            }
            "Borneo FC" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/506141-1688186726.jpg",
                        nama = "Nadeo Argawinata",
                        posisi = "Kiper",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/817984-1688189681.jpg",
                        nama = "Komang Teguh ",
                        posisi = "Gel. Bertahan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/195271-1688190074.jpg",
                        nama = "Stefano Lilipaly ",
                        posisi = "Sayap Kiri",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/506154-1688190120.jpg",
                        nama = "Terens Puhiri",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                )
            }
            "Dewa United" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/548371-1580392921.png",
                        nama = "Egy Maulana Vikri",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/648128-1634104487.jpg",
                        nama = "Ricky Kambuaya",
                        posisi = "Gel. Serang",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/721914-1642988373.jpg",
                        nama = "Septian Bagaskara",
                        posisi = "Depan-Tengah",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/162261-1606070199.png",
                        nama = "Dimitrios Kolovos",
                        posisi = "Gel. Serang",
                        negara = "Yunani",
                    ),
                )
            }
            "Arema FC" -> {
                return listOf(
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/505894-1702637521.png",
                        nama = "Dedik Setiawan",
                        posisi = "Depan-Tengah",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/186865-1702636999.png",
                        nama = "Dendi Santoso",
                        posisi = "Sayap Kanan",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/505897-1615478389.jpg",
                        nama = "Muhammad Rafli",
                        posisi = "Gel. Serang",
                        negara = "Indonesia",
                    ),
                    Pemain(
                        img = "https://img.a.transfermarkt.technology/portrait/medium/128174-1702636951.png",
                        nama = "Greg Nwokolo",
                        posisi = "Sayap Kiri",
                        negara = "Indonesia",
                    ),
                )
            }"Persita" -> {
            return listOf(
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/396123-1603741378.jpg",
                    nama = "Mohcine Hassan",
                    posisi = "Depan-Tengah",
                    negara = "Portugal",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/683218-1645078308.jpg",
                    nama = "Jack Brown",
                    posisi = "Gel. Serang",
                    negara = "Indonesia",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/506579-1643690621.jpg",
                    nama = "Ichsan Kurniawan",
                    posisi = "Gel. Bertahan",
                    negara = "Indonesia",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/505745-1640665093.jpg",
                    nama = "Adhitya Harlan",
                    posisi = "Kiper",
                    negara = "Indonesia",
                ),
            )
        }"PSM Makasar" -> {
            return listOf(
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/663274-1672621754.jpg",
                    nama = "Yakob Sayuri",
                    posisi = "Sayap Kanan",
                    negara = "Indonesia",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/380177-1689559408.jpeg",
                    nama = "Kenzo Nambu",
                    posisi = "Gel. Serang",
                    negara = "Jepang",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/875177-1648268787.jpg",
                    nama = "Yance Sayuri",
                    posisi = "Bek-Kiri",
                    negara = "Indonesia",
                ),
                Pemain(
                    img = "https://img.a.transfermarkt.technology/portrait/medium/252711-1643695791.jpg",
                    nama = "Rasyid Bakri",
                    posisi = "Gel. Tengah",
                    negara = "Indonesia",
                ),
            )
        }
            else ->
                return listOf()
        }

    }
}