package com.davidlutta.galactic_ninja.cryptowatch.Util;

public interface ItemTouchHelper {
    boolean onItemMove(int fromPostion , int toPosition);
    void onItemDismiss(int position);
}
