export default function Home(props) {
    console.log("The frontend did it. HER FAULT");
    return `
        <header>
            <img id="welcomeImage" src="/static/img/welcomelogo.png" alt="logo">
        </header>
        <main>
        <div id="background">
            <div>
                <p>
                    This is the home page text.
                </p>    
            </div>
            </div>
        </main>
    `;
}