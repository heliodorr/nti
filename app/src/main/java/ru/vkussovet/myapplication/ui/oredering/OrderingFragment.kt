package ru.vkussovet.myapplication.ui.oredering

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vkussovet.myapplication.databinding.FragmentOrderingBinding
import ru.vkussovet.myapplication.ui.oredering.categoryrecyclerview.CategoryRecyclerAdapter
import ru.vkussovet.myapplication.ui.oredering.categoryrecyclerview.ExtendedLM
import ru.vkussovet.myapplication.ui.oredering.menurecyclerview.ExtendedGLM
import ru.vkussovet.myapplication.ui.oredering.menurecyclerview.MenuItemDecoration
import ru.vkussovet.myapplication.ui.oredering.menurecyclerview.MenuRecyclerAdapter

class OrderingFragment : Fragment() {


    private val viewModel: OrderingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentOrderingBinding.inflate(inflater)
        setCategoryRecycler(binding)
        setMenuItemRecycler(binding)
        viewModel.initDownload()

        return binding.root
    }


    private fun setMenuItemRecycler(binding: FragmentOrderingBinding){

        val span = 2
        val space = 12

        val menuRecycler = binding.menuRecycler
        menuRecycler.layoutManager =
            ExtendedGLM(requireContext(), span)

        val adapter = MenuRecyclerAdapter(
            context = requireContext(),
            viewModel.onMenuItemChanged
        )

        menuRecycler.adapter = adapter

        menuRecycler.addItemDecoration(
            MenuItemDecoration(
                context = requireContext(),
                span = span,
                spaceInDp = space
            )
        )

        viewModel.menuItems.observe(viewLifecycleOwner){ data -> adapter.refresh(data) }

    }

    private fun setCategoryRecycler(binding: FragmentOrderingBinding){

        val categoryRecycler = binding.categoryRecycler
        categoryRecycler.layoutManager =
            ExtendedLM(requireContext())

        val adapter = CategoryRecyclerAdapter(
            context = requireContext(),
            viewModel.onMenuItemChanged,
            {str-> binding.foodNameInFragment.text = str}
        )

        categoryRecycler.adapter = adapter

        viewModel.categoryItems.observe(viewLifecycleOwner){ data -> adapter.refresh(data) }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderingFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}

