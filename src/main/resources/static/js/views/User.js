import router from "../router.js";
import render from "../render.js";
import {getAuthBearerTokenHeader} from "../auth.js";
import fetchData from "../fetchData.js";

export default function User(props) {
          console.log(props)
    return `<h1>${props.user[0].username}</h1>,
            <h2>${props.email}</h2>
`
}