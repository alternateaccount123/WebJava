const commentsList = document.getElementById('comments-list'); // Define commentsList variable
const responseDiv = document.getElementById('response');



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

//this works 
const loadComments = () => {
	//here the data is the comments 
	fetch('/message')
		.then(response => response.json())
		.then(data => {
			
			commentsList.innerHTML = ""; // Clear existing data
			data.forEach(comment => {
				const newComment = document.createElement("li");
				newComment.innerHTML = comment.message;
				commentsList.appendChild(newComment);
			});

		})
		.catch(error => {
			console.error('Error:', error);
		});
};

loadComments();  



//send to db ,veify is ok then  update list in html 
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
      console.log("trying to load new comment in li" + comment); 
      loadComments(); // reaload list after successfully sending comment to db
    })
    .catch(error => {
      console.error("Error adding comment:", error);
    });
}







