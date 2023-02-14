package kg.example.mangalib.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import kg.example.mangalib.databinding.FragmentTopMangaBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.topmanga.TopMangaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MangaFragment : BaseFragment<FragmentTopMangaBinding>() {
    private val viewModel: TopMangaViewModel by viewModel()

    private lateinit var adapter: MangaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MangaAdapter()
    }
    override fun inflate(layoutInflater: LayoutInflater): FragmentTopMangaBinding {
        return FragmentTopMangaBinding.inflate(layoutInflater)
    }

   override  fun initView() {

        viewModel.getAllTopManga()
        viewModel.getTopAllManga.collectState(
            onLoading = {

            },
            Error = {
                Log.e("ololo", "error: " )

            },
            onSuccess = {
                binding.recycle.adapter =adapter
                adapter.array(it)
                Toast.makeText(requireContext(),"success", Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: " )
            })
    }

    override fun initListener() {


    }

}
