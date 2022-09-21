import { NavLink } from "react-router-dom";

function Nav() {
    return (
        <div id="nav-inner">
            <img src="../img/flourish.png" alt="Decorative Flourish" id="top-nav-flourish" />
            <nav className="nav flex-column">
                <NavLink className="nav-link" to="/" id="home-link">
                    <img src="../img/pumpkin.png" alt="Link to Home Page; Pictured: a cute pumpkin illustration" id="home-pumpkin" />
                </NavLink>
                <NavLink className={({ isActive }) => (isActive ? "nav-link active" : "nav-link")} to="/products">Products</NavLink>
                <NavLink className={({ isActive }) => (isActive ? "nav-link active" : "nav-link")} to="/about">About</NavLink>
                <NavLink className={({ isActive }) => (isActive ? "nav-link active" : "nav-link")} to="/references">References</NavLink>
            </nav>
            <img src="../img/flourish.png" alt="Decorative Flourish" id="bottom-nav-flourish" />
        </div>
    )
}

export default Nav;