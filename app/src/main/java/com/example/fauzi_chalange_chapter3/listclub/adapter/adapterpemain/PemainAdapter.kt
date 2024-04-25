import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fauzi_chalange_chapter3.databinding.PemainListBinding
import com.example.fauzi_chalange_chapter3.listclub.ListPemainFragment
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterpemain.PemainAdapterListener
import com.example.fauzi_chalange_chapter3.listclub.adapter.adapterpemain.PemainDiffUtil
import com.example.fauzi_chalange_chapter3.listclub.data.Pemain
import com.example.fauzi_chalange_chapter3.listclub.viewholder.PemainViewHolder


class PemainAdapter(private val pemainAdapterListener: PemainAdapterListener
    ): ListAdapter<Pemain, PemainViewHolder>(PemainDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemainViewHolder {
        return PemainViewHolder(
            pemainViewBinding = PemainListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            pemainAdapterListener = pemainAdapterListener,

        )
    }
    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: PemainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    }