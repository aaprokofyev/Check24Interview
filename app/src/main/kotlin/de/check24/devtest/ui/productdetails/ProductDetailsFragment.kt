package de.check24.devtest.ui.productdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import de.check24.devtest.databinding.FragmentProductDetailsBinding
import de.check24.devtest.di.AppInjector
import de.check24.devtest.di.Injectable
import de.check24.devtest.ui.BaseFragment
import javax.inject.Inject

class ProductDetailsFragment : BaseFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ProductDetailsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ProductDetailsViewModel::class.java]
    }

    private val params by navArgs<ProductDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProductDetailsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.setProduct(params.product)

        return binding.root
    }

    override fun inject() {
        AppInjector.appComponent.inject(this)
    }
}