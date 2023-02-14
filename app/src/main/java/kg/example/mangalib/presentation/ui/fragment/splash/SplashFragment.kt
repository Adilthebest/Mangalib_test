package kg.example.mangalib.presentation.ui.fragment.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.example.mangalib.R
import kg.example.mangalib.databinding.FragmentSplashBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.manga.AllMangaViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val viewModel: AllMangaViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initView() {

        Handler(Looper.getMainLooper()).postDelayed ({
            findNavController().navigate(R.id.action_splashFragment_to_navigation_home)
        } ,1500)
    }

    override fun initListener() {
    }

}
