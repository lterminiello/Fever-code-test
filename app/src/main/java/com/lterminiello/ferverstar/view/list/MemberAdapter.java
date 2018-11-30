package com.lterminiello.ferverstar.view.list;

import android.databinding.DataBindingUtil;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lterminiello.ferverstar.R;
import com.lterminiello.ferverstar.databinding.MemberListItemBinding;
import com.lterminiello.ferverstar.model.Member;
import com.lterminiello.ferverstar.utils.Lists;
import com.lterminiello.ferverstar.viewmodel.list.MemberListItemViewModel;
import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Member> resultList = Lists.newArrayList();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        MemberListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
            , R.layout.member_list_item, parent, false);

        return new MemberViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MemberViewHolder) holder).bindMember(resultList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultList != null ? resultList.size() : 0;
    }

    public void setResultList(List<Member> results) {
        if (results != null) {
            resultList = results;
            notifyDataSetChanged();
        }
    }

    public static class MemberViewHolder extends RecyclerView.ViewHolder {

        MemberListItemBinding crewListItemBinding;

        public MemberViewHolder(MemberListItemBinding crewListItemBinding) {
            super(crewListItemBinding.container);
            this.crewListItemBinding = crewListItemBinding;
        }

        void bindMember(Member result) {
            if (crewListItemBinding.getViewModel() == null) {
                crewListItemBinding.setViewModel(
                    new MemberListItemViewModel(result));
            } else {
                crewListItemBinding.getViewModel().setMember(result);
            }
        }
    }
}
