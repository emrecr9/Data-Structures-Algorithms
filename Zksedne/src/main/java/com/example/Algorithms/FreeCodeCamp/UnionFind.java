package com.example.Algorithms.FreeCodeCamp;

public class UnionFind
{
    private int size; //number of elements in the union find
    private int [] sz;//use to track size of each component
    private int [] id; //id[i] points to yhe parent of i, if id[i] = i, then i is a root node
    private int  numComponents; //tracks number of componenets in the union find

    public UnionFind(int size)
    {
        if (size <= 0)
            throw new IllegalArgumentException("Size <=0 not allowed");

        this.size = numComponents = size;
        sz = new int [size];
        id = new int [size];

        for (int i = 0; i < size; i++)
        {
            id[i] = i;
            sz[i] = i;
        }
    }

    public int find (int p)
    {
        int root = p;

        //find the root of the component/Set
        while (root != id [root])
            root = id [root];

        //compress the path
        while (p != root)
        {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public boolean connected (int p, int q)
    {
        return find(p) == find (q);
    }

    public int componentSize(int p) { return sz[find(p)];}
    public int size() { return size; }
    public int components() { return  numComponents;}

    public void unify (int p, int q)
    {
        int root1 = find(p);
        int root2 = find(q);

        //they are already in the same group
        if (root1 == root2)
            return;

        //merge smaller set to larger set
        if (sz[root1] < sz[root2])
        {
            sz[root2] = sz[root2] + sz[root1];
            id[root1] = root2;
        }
        else
        {
            sz[root1] = sz[root2] + sz[root1];
            id[root2] = root1;
        }

        //since there is a merge -> components/sets decreased by one
        numComponents--;
    }
}
