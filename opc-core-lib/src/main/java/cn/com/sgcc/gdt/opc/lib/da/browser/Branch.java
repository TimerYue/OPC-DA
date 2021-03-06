package cn.com.sgcc.gdt.opc.lib.da.browser;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Branch {
    private Branch parent = null;

    private String name = null;

    private Collection<Branch> branches = new LinkedList<Branch>();

    private Collection<Leaf> leaves = new LinkedList<Leaf>();

    /**
     * Create a branch to the virtual root folder
     */
    public Branch() {
        super();
    }

    /**
     * Create a branch with a parent branch and a name of this branch.
     *
     * @param parent The parent of this branch
     * @param name   The name of this branch
     */
    public Branch(final Branch parent, final String name) {
        super();
        this.name = name;
        this.parent = parent;
    }

    /**
     * Get all branches.
     * <br/>
     * They must be filled first with a fill method from the {@link TreeBrowser}
     *
     * @return The list of branches
     */
    public Collection<Branch> getBranches() {
        return this.branches;
    }

    public void setBranches(final Collection<Branch> branches) {
        this.branches = branches;
    }

    /**
     * Get all leaves.
     * <br/>
     * They must be filled first with a fill method from the {@link TreeBrowser}
     *
     * @return The list of leaves
     */
    public Collection<Leaf> getLeaves() {
        return this.leaves;
    }

    public void setLeaves(final Collection<Leaf> leaves) {
        this.leaves = leaves;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Branch getParent() {
        return this.parent;
    }

    /**
     * Get the list of names from the parent up to this branch
     *
     * @return The stack of branch names from the parent up this one
     */
    public Collection<String> getBranchStack() {
        LinkedList<String> branches = new LinkedList<String>();

        Branch currentBranch = this;
        while (currentBranch.getParent() != null) {
            branches.add(currentBranch.getName());
            currentBranch = currentBranch.getParent();
        }

        Collections.reverse(branches);
        return branches;
    }

}
