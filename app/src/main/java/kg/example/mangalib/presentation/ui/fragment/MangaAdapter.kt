package kg.example.mangalib.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kg.example.mangalib.databinding.ItemMangaBinding
import kg.example.mangalib.domain.model.MangalibModel
import kg.example.mangalib.domain.model.ResultModel

class MangaAdapter: PagingDataAdapter<ResultModel, MangaAdapter.MangaViewHolder>(MangaModelItemCallback) {
    private var list = mutableListOf<ResultModel>()
    var onClick: ((ResultModel) -> Unit)? = null
    var onLongClick: ((ResultModel) -> Unit)? = null

   inner class MangaViewHolder(private val binding: ItemMangaBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(resultModel: ResultModel) {
            binding.imageMango.load(resultModel.image)
            binding.tvYear.text = resultModel.issue_year.toString()
            binding.tvDesc.text = resultModel.ru_name

            itemView.setOnClickListener {
                onClick?.invoke(resultModel)
            }
            itemView.setOnLongClickListener {
                onLongClick?.invoke(resultModel)
                return@setOnLongClickListener true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(ItemMangaBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
holder.bind(list[position])
    }

    override fun getItemCount(): Int {
return list.size
    }

    private object MangaModelItemCallback : DiffUtil.ItemCallback<ResultModel>(){
        override fun areItemsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultModel, newItem: ResultModel): Boolean {
            return oldItem == newItem
        }
    }
    fun array(arrayList: List<ResultModel>) {
        list = arrayList as ArrayList<ResultModel>
    }
    fun setContentList (list: MutableList<ResultModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}