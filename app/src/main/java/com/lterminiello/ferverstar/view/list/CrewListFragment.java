package com.lterminiello.ferverstar.view.list;

import android.app.ActionBar;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lterminiello.ferverstar.MainApplication;
import com.lterminiello.ferverstar.R;
import com.lterminiello.ferverstar.databinding.CrewListFragmentBinding;
import com.lterminiello.ferverstar.usecase.UseCaseFactory;
import com.lterminiello.ferverstar.viewmodel.CrewViewModelFactory;
import com.lterminiello.ferverstar.viewmodel.list.CrewListViewModel;

public class CrewListFragment extends Fragment {

    public static final String TAG = "CrewListFragment";

    private CrewListViewModel viewModel;

    private CrewListFragmentBinding binding;

    private MemberAdapter adapter;

    private String query;

    public static CrewListFragment newInstance(CrewViewModelFactory crewViewModelFactory) {
        CrewListFragment fragment = new CrewListFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        adapter = new MemberAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.crew_list_fragment, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbar);

        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel =
            ViewModelProviders.of(this, MainApplication.getCrewViewModelFactory()).get(CrewListViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getCrew();
        subscriberObserver();
    }

    private void subscriberObserver() {
        viewModel.getMemberData().observe(this, members -> {
            adapter.setResultList(members);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        binding.crewList.setAdapter(adapter);
        binding.crewList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.crewList.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

    }

   /* @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list_toolbar, menu);
        MenuItem mSearch = menu.findItem(R.id.action_search);
        initSearchView(mSearch);
        super.onCreateOptionsMenu(menu, inflater);
    }*/

}
