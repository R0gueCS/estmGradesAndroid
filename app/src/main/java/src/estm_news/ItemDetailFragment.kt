package src.estm_news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import src.estm_news.databinding.FragmentItemDetailBinding
import src.estm_news.placeholder.PlaceholderContent

class ItemDetailFragment : Fragment() {

    private var item: PlaceholderContent.Module? = null
    lateinit var itemDetailTextView: TextView
    private var toolbarLayout: CollapsingToolbarLayout? = null
    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = PlaceholderContent.modules_map[it.getString(ARG_ITEM_ID)]
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root
        toolbarLayout = binding.toolbarLayout
        itemDetailTextView = binding.itemDetail!!
        updateContent()
        return rootView
    }

    private fun updateContent() {
        try {
            toolbarLayout?.title = item?.nom_module
            item?.let {
                itemDetailTextView.text = item!!.description
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}