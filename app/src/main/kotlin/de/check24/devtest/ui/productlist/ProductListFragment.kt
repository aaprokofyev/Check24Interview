package de.check24.devtest.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import de.check24.devtest.R
import de.check24.devtest.databinding.FragmentProductListBinding
import de.check24.devtest.di.AppInjector
import de.check24.devtest.di.Injectable
import de.check24.devtest.domain.model.Product
import de.check24.devtest.ui.BaseFragment
import de.check24.devtest.ui.action.ProductActionListener
import de.check24.devtest.ui.adapter.ProductListAdapter
import de.check24.devtest.ui.widget.MarginItemDecoration
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListFragment : BaseFragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ProductListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ProductListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProductListBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.list.adapter = ProductListAdapter(object : ProductActionListener {
            override fun viewProductDetails(product: Product) {
                findNavController().navigate(
                    ProductListFragmentDirections.viewProductDetails(
                        product = product
                    )
                )
            }
        }).apply {
            viewModel.products.observe(viewLifecycleOwner) {
                lifecycleScope.launch { setData(it) }
            }
        }
        binding.list.addItemDecoration(
            MarginItemDecoration(
                context = requireContext(),
                verticalMarginRes = R.dimen.common_spacing_half
            )
        )
        return binding.root
    }

    override fun inject() {
        AppInjector.appComponent.inject(this)
    }
}