import { useState } from "react";
import { Routes, Route } from "react-router-dom";
import Nav from "./components/Nav";
import Home from "./components/Home";
import Products from "./components/Products";
import About from "./components/About";
import References from "./components/References";
import Form from "./components/Form";
import Footer from "./components/Footer";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);

  return (
    <div className="container-fluid g-0 full-height">
      <div className="row g-0 full-height">
        <div className="col-4 full-height" id="nav">
          <Nav />
        </div>
        <div className="col-8 full-height" id="main">
          <div id="content">
            <Routes>
              <Route end path="/" element={<Home />} />
              <Route path="/products" element={<Products products={products} setProducts={setProducts} setCategories={setCategories} />} />
              <Route path="/about" element={<About />} />
              <Route path="/references" element={<References />} />
              <Route path="/add" element={<Form products={products} setProducts={setProducts} categories={categories} />} />
            </Routes>
          </div>
          <div id="footer">
            <Footer />
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
