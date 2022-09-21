import { useEffect } from "react";
import { Link } from "react-router-dom";
import Product from "./Product";

function Products({products, setProducts, setCategories}) {

    useEffect(() => {
        fetch("http://localhost:8080/api/products")
        .then(response => response.json())
        .then(data => productManager(data))
        .catch(error => console.error(error));
    })

    const productManager = (productData) => {
        setProducts(productData);
        
        let categories = productData.map(product => product.category).filter((category, i, ar) => ar.indexOf(category) === i).sort();
        setCategories(categories);
    }

    const productFactory = () => {
        return products.map(product => {
            return (
                <div className="col-4" key={"product_" + product.id}>
                    <div className="product-container">
                        <Product product={product} />
                    </div>
                </div>
            )
        })
    }

    const sortByName = () => {
        let productsCopy = [...products];
        
        productsCopy.sort((a, b) => {
            let na = a.name.toLowerCase();
            let nb = b.name.toLowerCase();

            if (na < nb) {
                return -1;
            }
            else if (na > nb) {
                return 1;
            }
            else {
                return 0;
            }
        });

        setProducts(productsCopy);
    }

    const sortByCategory = () => {
        let productsCopy = [...products];
        
        productsCopy.sort((a, b) => {
            let ca = a.category.toLowerCase();
            let cb = b.category.toLowerCase();

            if (ca < cb) {
                return -1;
            }
            else if (ca > cb) {
                return 1;
            }
            else {
                return 0;
            }
        });

        setProducts(productsCopy);

    }

    const sortByRating = () => {
        let productsCopy = [...products];
        
        productsCopy.sort((a, b) => b.rating - a.rating)

        setProducts(productsCopy);
    }

    return (
        <div className="row" id="product-inner">
            <div className="col-3 d-grid">
                <button onClick={sortByName} className="btn btn-primary mb-5">Sort By Name</button>
            </div>
            <div className="col-3 d-grid">
                <button onClick={sortByCategory} className="btn btn-dark mb-5">Sort By Category</button>
            </div>
            <div className="col-3 d-grid">
                <button onClick={sortByRating} className="btn btn-warning mb-5">Sort By Rating</button>
            </div>
            <div className="col-3 d-grid">
                <Link className="btn btn-success mb-5" to="/add">Add Product</Link>
            </div>
            {productFactory()}
        </div>
    );
}

export default Products;