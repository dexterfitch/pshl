function Form({products, setProducts, categories}) {

    const categorySelect = () => {
        return categories.map(category => <option value={category}>{category}</option>)
    }

    const onSubmit = (productObj) => {
        fetch("http://localhost:8080/api/products", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(productObj)
        })
        .then(response => responseToMessage(response))
        .then(data => setProducts([...products, data]))
        .catch(error => console.error(error));
    }

    const responseToMessage = (response) => {
        const firstNum = response.status.toString().charAt(0);
        switch(firstNum) {
            case "2": 
                console.log(`Solar Panel has been updated!`);
                return response.json();
            case "4": 
                console.error("400 Error: Something went wrong!");
                break;
            case "5":
                console.error("500 Error: Server not responding!");
                break;
            default:
                break;
        }
    }

    return (
        <div className="row">
            <div className="col-6 offset-3">
                <p className="display-2 text-center mt-5 mb-4">Add Product</p>
                <form onSubmit={onSubmit}>
                    <label className="form-label mb-0" htmlFor="product-name-input">Name</label>
                    <input type="text" className="form-control mb-3" id="product-name-input" required />

                    <label className="form-label mb-0" htmlFor="product-category-input">Category</label>
                    <select className="form-select mb-3" id="product-category-input" aria-label="Category Selection" name="Category Selection" required>
                        <option value="">-- Select One --</option>
                        {categorySelect()}
                    </select>

                    <label className="form-label mb-0" htmlFor="product-price-input">Price</label>
                    <input type="number" className="form-control mb-3" id="product-price-input" min="0.01" max="999.99" step="any" required />

                    <label className="form-label mb-0" htmlFor="product-link-input">Link</label>
                    <input type="text" className="form-control mb-3" id="product-link-input" />

                    <label className="form-label mb-0" htmlFor="product-image-input">Image</label>
                    <input type="text" className="form-control mb-3" id="product-image-input" />

                    <input type="checkbox" className="form-check-input mb-3" id="product-tried-input" />
                    <label className="form-check-label mb-0" htmlFor="product-tried-input">&nbsp;Tried it?</label>
                    <br />
                    <p className="mt-4">If you have tried this product, feel free to add a rating and review, otherwise, please ignore these inputs.</p>
                    <label className="form-label mb-0" htmlFor="product-rating-input">Rating</label>
                    <input type="number" className="form-control mb-3" id="product-rating-input" min="0" max="5" placeholder="0"/>

                    <label className="form-label mb-0" htmlFor="product-review-input">Review</label>
                    <textarea type="text" className="form-control mb-3" id="product-review-input" />

                    <div className="text-center">
                        <button className="btn btn-success btn-lg mt-5" type="submit">Add New Product</button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Form;