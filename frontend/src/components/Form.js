function Form() {
    // {
    //     "product": {
    //       "id": 20,
    //       "name": "Air Wick Essential Air Freshener Mist Kit - Pumpkin Spice - 0.67 fl oz/2ct",
    //       "category": "Air Freshener",
    //       "price": 10.99,
    //       "link": "https://www.target.com/p/air-wick-essential-air-freshener-mist-kit-pumpkin-spice-0-67-fl-oz-2ct/-/A-86119024",
    //       "image": "../img/20.jpg",
    //       "tried": true,
    //       "rating": 3,
    //       "review": "This was not the scent I thought it would be. There was no spice cinnamon or nutmeg aroma. It was more of a vanilla floral aroma which was okay but not at all the scent that I would have imagined with a pumpkin spice name. It has more of a soft laundry soap scent."
    //     }
    //   }
    return (
        <div className="row">
            <div className="col-6 offset-3">
                <p className="display-2 text-center my-5">Add Product</p>
                <form className="form-floating">
                    <input type="text" className="form-control" id="product-name-input" placeholder="Product name..." />
                    <label for="product-name-input">Product Name</label>
                    <div className="text-center">
                        <button className="btn btn-success btn-lg mt-5" type="submit">Add New Product</button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Form;