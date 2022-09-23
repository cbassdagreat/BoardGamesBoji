package cbassdagreat.github.boardgamesboji.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cbassdagreat.github.boardgamesboji.R
import cbassdagreat.github.boardgamesboji.adapter.BojiItemAdapter
import cbassdagreat.github.boardgamesboji.databinding.FragmentListaBinding
import cbassdagreat.github.boardgamesboji.model.BojiItem
import cbassdagreat.github.boardgamesboji.viewmodel.BojiViewModel


class ListaFragment : Fragment() {

    lateinit var binding:FragmentListaBinding
    private val viewModel by activityViewModels<BojiViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater)

        val adapter = BojiItemAdapter()
        adapter.setMiOnClickListener(object : BojiItemAdapter.MiOnClickListener{
            override fun onClickListener(bojiItem: BojiItem) {
                Navigation.findNavController(requireView()).navigate((R.id.action_listaFragment_to_detalleFragment))
            }
        })

        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvLista.adapter = adapter
            rvLista.layoutManager = layoutManager
        }

        viewModel.listaBoji.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        return binding.root
    }

}