# Study Group with Motion Lab

Hi! My name is **Genta Halilintar**, and I'm an intern at **Motion Lab**.  
I'm excited to share my knowledge with you about **Study with Motion Lab**.

This guide covers essential Git commands to help you manage and collaborate on projects using version control. Perfect for beginners!

---

## Getting Started

### Clone a Repository Using SSH
To clone a Git repository using SSH, use the following command:  
- `git clone git@github.com:username/repository.git`

### Working with Files
- `git add .` - Stage all changes in the repository.
- `git commit -m "Initial commit"` - Commit staged changes with a descriptive message.
- `git push origin master` - Push your local changes to the remote repository.
- `git pull origin master` - Fetch and integrate changes from the remote repository to your local branch.

### Branching and Merging
- `git branch new-feature` - Create a new branch named "new-feature" for independent development.
- `git checkout new-feature` - Switch to the "new-feature" branch.
- `git merge master` - Integrate changes from the master branch into the current branch.
- `git branch -d new-feature` - Delete the "new-feature" branch after merging.

### Viewing Changes and History
- `git log` - Display the commit history.
- `git status` - Show the current state of the repository (staged, unstaged, and untracked files).
- `git diff` - Compare changes between the working directory and the index.

### Reverting and Resetting
- `git reset --hard` - Reset the repository to a specific previous commit (caution: this can remove changes).
- `git revert` - Create a new commit that undoes a previous commit.

### Using Stash
- `git stash` - Temporarily save uncommitted changes.
- `git stash pop` - Reapply stashed changes.
- `git stash drop` - Delete the most recent stash entry.

---

Happy to be here and Enjoy with My Code! 🚀