# Passporter Challenge

## Notes

You have app config in com.pedro.passporter/data/models/PassporterConfig if you want change github user, change page size or add a token

## Instructions

This challenge would give us an idea about your coding skills.

### Steps

1. Bootstrap a new Android app.
2. Request the GitHub API to show your own GitHub repositories
(https://api.github.com/users/<your_username>/repos) and parse the JSON
response. (If you don’t own a github account then list any other user’s account)
3. Display a list of repositories, each entry should show
repo name
description
login of the owner
4. Request only 10 repos at a time. Use an endless list with a load more
mechanism. The load more should be triggered when the scrolling is close to
reaching the end of the list. Check the pagination documentation.
5. Show a light green background if the fork flag is false or missing, a white one
otherwise.
6. On a long click on a list item show a dialog to ask if to go to repository html_url
or owner html_url which is opened then in the browser.

### Additional notes

Important for us is code efficiency, following best practices & code readability.
Don't focus too much on design.
We would prefer you use coroutines and flow if needed
If your API request limit exceeds, you can generate and use a personal access
token here and add ?access_token=<YOUR_ACCESS_TOKEN> to the request
URLs.
If you want to use different branches, please make sure that they'll be merged
into master branch when you finish the task.

### Bonus points

Provide a comprehensive git history.