import router from "../router.js";
import render from "../render.js";
import {getAuthBearerTokenHeader} from "../auth.js";
import fetchData from "../fetchData.js";

export default function createView(URI) {

    let route = router(URI);

    // if route is invalid, return a 404 page
    if (!route) {
        render(null, router('/error'));
        return;
    }

    // change view to loading screen
    render(null, router('/loading'));

    let request = {
        headers: getAuthBearerTokenHeader()
    }
    fetchData(route.state, request).then((props) => {
        render(props, route);
    });
}