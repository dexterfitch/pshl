function Product({product}) {

    const moneyFormat = () => {
        let price = `${product.price}`;
        let cents = price.split(".")[1];

        if (cents === undefined) {
            return price + ".00";
        } 
        else if (cents.length === 1) {
            return price + "0";
        }
        else {
            return price;
        }
    }

    return (
        <>
            <div className="card product-card">
                <img className="p-4" src={product.image} alt={product.name} />
                <div className="card-body">
                    <h5 className="card-title">{product.name}</h5>
                    <div className="row">
                        <div className="col-6 pt-1">
                            <p className="card-text"><b>Category:</b> {product.category}</p>
                        </div>
                        <div className="col-4 pt-1">
                            <p className="card-text"><b>Price:</b> ${moneyFormat()}</p>
                        </div>
                        <div className="col-2 text-end">
                            <a href={product.link} target="_new">
                                <button className="btn btn-primary btn-sm">Link</button>
                            </a>
                        </div>
                    </div>
                    <div className="text-center pt-3 d-grid">
                        <button type="button" className="btn btn-success btn-sm btn-block" data-bs-toggle="modal" data-bs-target={"#modal_" + product.id}>
                            More Details
                        </button>
                    </div>
                </div>
            </div>
            
            <div className="modal fade" id={"modal_" + product.id} tabIndex="-1" aria-labelledby={"modal_label_" + product.id} aria-hidden="true">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <h4 className="modal-title" id={"modal_label_" + product.id}>{product.name}</h4>
                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div className="modal-body">
                            <div className="row">
                                <div className="col-7">
                                    <img className="img-fluid px-5" src={product.image} alt={product.name} />
                                </div>
                                <div className="col-5 mt-5">
                                    <p><b>Category:</b> {product.category}</p>
                                    <p><b>Price:</b> ${moneyFormat()}</p>
                                    <p><b>Rating:</b> {product.rating !== 0 ? product.rating + "/5" : "Unrated"}</p>
                                    <p><b>Tried:</b> {product.tried ? "Yes" : "No"}</p>
                                    <p><b>Review:</b> {product.review.length > 0 ? product.review : "N/A"}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Product;