

//const addCommentForm = document.getElementById("add-comment-form");
const commentsList = document.getElementById("comments-list");

/*
addCommentForm.addEventListener("submit", function(event) {
  event.preventDefault();
  const commentText = document.getElementById("comment-text").value;
  if (!commentText) {
    return;
  }
  addComment(commentText);
});
*/

// Load comments from the server
function loadComments() {
  fetch("/comments") // Assuming the server endpoint is "/comments"
    .then(response => response.json())
    .then(comments => {
      commentsList.innerHTML = ""; // Clear existing comments

      comments.forEach(comment => {
        const newComment = document.createElement("li");
        newComment.innerHTML = comment.message;
        commentsList.appendChild(newComment);
      });
    })
    .catch(error => {
      console.error("Error loading comments:", error);
    });
}


/*
// Add a comment to the comments list
function addComment(comment) {
  fetch("/comments", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      message: comment
    })
  })
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error("Error adding comment.");
    })
    .then(comment => {
      const newComment = document.createElement("li");
      newComment.innerHTML = comment.message;
      commentsList.appendChild(newComment);
      document.getElementById("comment-text").value = "";
    })
    .catch(error => {
      console.error("Error adding comment:", error);
    });
}
*/


// Load comments when the page is loaded
document.addEventListener("DOMContentLoaded", function() {
  loadComments();
});
