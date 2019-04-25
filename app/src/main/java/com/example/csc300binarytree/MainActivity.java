package com.example.csc300binarytree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView payloadTV;
    private Button leftButton, rightButton;
    private BinaryTree2 myTree;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.payloadTV = this.findViewById(R.id.payloadTV);
        this.leftButton = this.findViewById(R.id.leftBtn);
        this.rightButton = this.findViewById(R.id.rightBtn);

        if(this.getIntent().hasExtra("myTree"))
        {
            this.myTree = (BinaryTree2) this.getIntent().getSerializableExtra("myTree");
        }
        else
        {
            BinaryTree2 bt = new BinaryTree2(5);
            bt.add(3);
            bt.add(3);
            bt.add(8);
            bt.add(6);
            bt.visitInOrder();
        }

        this.payloadTV.setText("" + this.myTree.payload);
        this.hideButtons();
    }

    private void hideButtons()
    {
        if(this.myTree.left == null)
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }

        if(this.myTree.right == null)
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }

    public void onRightClickButton(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("myTree", this.myTree.right);
        this.startActivity(i);
    }

    public void onLeftClickButton(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("myTree", this.myTree.left);
        this.startActivity(i);
    }
}//class
