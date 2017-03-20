# Bioscoop App

## Links

[**Google Drive**](https://drive.google.com/drive/u/1/folders/0B-eXbuoU1hYkeURRZXNlNG1uVGs "Group Google Drive")

[**TMDb API**](https://developers.themoviedb.org/3/getting-started "The Movie Database API Documentation")

[**Git command conventions**](../master/conventions/GIT.md)

## Git Commands
### Push changes to repo
```git
git add *
```
Add all files and directories (which are not included in the .gitignore file) that has changed to your new commit.

```git
git commit -m "Commit message"
```
Use the commit message for a brief summary of what you changed in this commit since your last edit.

```git
git push origin branchname
```
Use this to push your changes to the branch specified in __branchname__.
##### NEVER PUSH IN THE MASTER BRANCH!

### Pull changes from repo

```git
git pull origin branchname
```
Use this to pull the changes from the remote repo to your local repo.

### Branches
```git
git branch
```
Shows what branch you are currently on and what branches are available.
##### Make sure you are **not** in the master branch before you make changes to the project.

```git
git checkout branchname
```
Switch to branch __branchname__.
