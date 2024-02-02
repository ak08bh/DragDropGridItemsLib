package com.example.dragdroplib;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private final HelperAdapter mAdapter;
    private int fromPos = -1;
    private int toPos = -1;

    public SimpleItemTouchHelperCallback(HelperAdapter adapter) {
        mAdapter = adapter;
    }


    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                          RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        /*fromPos = viewHolder.getAdapterPosition();
        toPos = target.getAdapterPosition();*/
        return true;
    }


/*    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder,
                                  int actionState) {
        // We only want the active item
        switch (actionState) {
            case ItemTouchHelper.ACTION_STATE_DRAG: {
                fromPos = viewHolder.getAdapterPosition();
                break;
            }

            case ItemTouchHelper.ACTION_STATE_IDLE: {
                //Execute when the user dropped the item after dragging.
                if (fromPos != -1 && toPos != -1
                        && fromPos != toPos) {
                    mAdapter.onItemMove(fromPos, toPos);
                    fromPos = -1;
                    toPos = -1;
                }
                break;
            }
        }
    }*/
}
