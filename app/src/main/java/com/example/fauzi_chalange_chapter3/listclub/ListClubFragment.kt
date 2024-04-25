package com.example.fauzi_chalange_chapter3.listclub
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fauzi_chalange_chapter3.databinding.FragmentListBinding
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub.ClubAdapter
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterclub.ClubAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.data.Club

class ListClubFragment : Fragment(), ClubAdapterListener {

    private lateinit var binding: FragmentListBinding
    private val clubAdapter = ClubAdapter(this)
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
        clubAdapter.submitList(clubData())
    }


    private fun setupRecyclerView(context: Context) {
        binding.recyclerView.adapter = clubAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(
            context,
            2
        )
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
    }

    private fun goToThirdFragment(data: Club) {
        val actionToPemainFragment = ListClubFragmentDirections.actionListClubFragmentToListPemainFragment()
        actionToPemainFragment.nama = data.nama
        findNavController().navigate(actionToPemainFragment)
    }

    override fun onClickClub(data: Club) {
        goToThirdFragment(data)
    }

    private fun clubData(): List<Club> {
        return listOf(
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/49425.png",
                nama = "Bali United",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14107.png",
                nama = "Persija",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/20646.png",
                nama = "PSIS",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14105.png",
                nama = "Persib",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/31444.png",
                nama = "Persebaya",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/50276.png",
                nama = "Borneo FC",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/72710.png",
                nama = "Dewa United",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/12971.png",
                nama = "Arema FC",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14112.png",
                nama = "Persita",
            ),
            Club(
                image = "https://tmssl.akamaized.net/images/wappen/head/14104.png",
                nama = "PSM Makasar",
            ),
        )
    }
}