export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
<!--MAKE CREATE FORM HERE-->
            <div class="post-container">
                ${props.posts.map(post =>
        `
                        <h3>${post.title}</h3>
                        <h2>${post.content}</h2>
       <!--add edit, delete buttons, add edit form-->
        
        
        `                  ).join('')}   
            </div>
            
            
        </main>
    `;
}

export function PostsEvent(){
    //add event listeners, get data, send fetch
}