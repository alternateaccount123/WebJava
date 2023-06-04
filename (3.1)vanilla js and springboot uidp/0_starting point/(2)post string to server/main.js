




const addCommentForm = document.getElementById("add-comment-form");
addCommentForm.addEventListener("submit", function(event) {
  event.preventDefault();
  const commentText = document.getElementById("comment-text").value;
  if (!commentText) {
    return;
  }
  console.log(commentText);
  document.getElementById("comment-text").value = ""; // Clear the input field
  addComment(commentText);
  
});


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
		//code here to do something with the data 
		console.log(comment);
    })
    .catch(error => {
      console.error("Error adding comment:", error);
    });
}











