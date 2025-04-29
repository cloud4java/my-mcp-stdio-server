# Instructions for Pushing to GitHub

Follow these steps to push your code to GitHub:

## 1. Create a new GitHub repository

1. Go to [GitHub](https://github.com/) and sign in to your account
2. Click on the "+" icon in the top-right corner and select "New repository"
3. Enter a name for your repository (e.g., "spring-ai-mcp-weather-stdio-server")
4. Optionally add a description
5. Choose whether the repository should be public or private
6. Do NOT initialize the repository with a README, .gitignore, or license (since we already have these files locally)
7. Click "Create repository"

## 2. Add the GitHub repository as a remote

After creating the repository, GitHub will show you commands to use. Copy the HTTPS or SSH URL of your repository and run the following command in your terminal:

```
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY-NAME.git
```

Replace `YOUR-USERNAME` and `YOUR-REPOSITORY-NAME` with your GitHub username and the name you gave to your repository.

## 3. Push your code to GitHub

Push your code to the GitHub repository:

```
git push -u origin master
```

This will push your local master branch to the remote repository and set up tracking.

## 4. Verify the push

1. Go to your GitHub repository in a web browser
2. You should see all your files and commit history

## Additional Information

- If you're using SSH for GitHub authentication, use the SSH URL instead of HTTPS
- If you encounter authentication issues with HTTPS, you may need to use a personal access token instead of your password
- For more information, refer to [GitHub's documentation](https://docs.github.com/en/get-started/quickstart/create-a-repo)