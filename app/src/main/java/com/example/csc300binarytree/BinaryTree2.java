package com.example.csc300binarytree;

public class BinaryTree2
{
    private int payload;
    private BinaryTree2 left;
    private BinaryTree2 right;

    public BinaryTree2(int payload)
    {
        this.payload = payload;
        this.left = null;
        this.right = null;
    }

    public void visitInOrder()
    {
        if(this.left != null)
        {
            this.left.visitInOrder(); //blocks
        }
        System.out.println("**** " + this.payload);
        if(this.right != null)
        {
            this.right.visitInOrder();
        }
    }

    public void add(int payloadToAdd)
    {
        if(payloadToAdd <= this.payload)
        {
            //add to the left
            if(this.left == null)
            {
                this.left = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.left.add(payloadToAdd);
            }
        }
        else
        {
            //add to the right
            if(this.right == null)
            {
                this.right = new BinaryTree2(payloadToAdd);
            }
            else
            {
                this.right.add(payloadToAdd);
            }
        }
    }
}
