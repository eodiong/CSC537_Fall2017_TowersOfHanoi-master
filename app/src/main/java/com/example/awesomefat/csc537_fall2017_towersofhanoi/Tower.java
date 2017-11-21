package com.example.awesomefat.csc537_fall2017_towersofhanoi;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by awesomefat on 11/7/17.
 */

public class Tower
{
    private Disk top;
    private ViewGroup theView;

    public Tower(ViewGroup theView)
    {
        this.theView = theView;
        this.theView.removeAllViews();
        this.top = null;
    }

    /*
    currently does NOT check the Tower of Hanoi rules for placing a disk
    1. if the tower is empty, a push is allowed
    2. otherwise, if the disk at the top of the tower is larger than the
       disk I am trying to push it is a LEGAL move
    3. If the disk at the top of the tower is smaller than the disk I am
       trying to push, then it is an ILLEGAL move and should not be allowed
    HINT: Make this guy return true when a move was successfully made, and
          false otherwise.  This way you know whether to clear out the landing
          zone, or reset it to what it was before we tried to make this move.
     */
    public boolean push(Disk d, Context context)
    {
        String s1=d.getTheView().getText().toString();
        String s2[]=s1.split(" ");
        Integer i=Integer.parseInt(s2[1]);
        Integer i1 = 0;
        if(this.top!=null) {
            s1 = this.top.getTheView().getText().toString();
            s2 = s1.split(" ");
            i1 = Integer.parseInt(s2[1]);
        }

        if(this.top == null)
        {
            this.top = d;
            this.theView.addView(d.getTheView(), 0);
            return true;
        }
        else if(i>i1)
    {
        Toast.makeText(context, "Illegal Move", Toast.LENGTH_SHORT).show();
        return false;
    }
        else
        {
            
            d.setNextDisk(this.top);
            this.top = d;
            this.theView.addView(d.getTheView(), 0);
            return true;
        }

        //visually put this disk at the top of this view

    }

    public Disk pop()
    {
        Disk diskToReturn = this.top;

        if(this.top != null)
        {
            this.top = this.top.getNextDisk();
            diskToReturn.setNextDisk(null);
            this.theView.removeViewAt(0);
        }
        return diskToReturn;
    }

    public ViewGroup getTheView() {
        return theView;
    }

    public void setTheView(ViewGroup theView) {
        this.theView = theView;
    }

    public Disk peek()
    {
        return this.top;
    }
}
