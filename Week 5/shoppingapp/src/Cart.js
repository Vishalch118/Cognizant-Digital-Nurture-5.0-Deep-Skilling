import React from "react";

class Cart extends React.Component{
    render(){
        return(
            <table border="1"
                    style={{
                        margin:"auto",
                        color:"green"
                    }}
            >
                <thead>
                    <tr>
                        <th style={{padding:"5px 12px"}}>Name</th>
                        <th style={{padding:"5px 12px"}}>Price</th>
                    </tr>
                </thead>

                <tbody>
                    {this.props.item.map((item,index)=>{
                        return(
                            <tr key={index}>
                                <td style={{padding:"5px 12px"}}>{item.itemname}</td>
                                <td style={{padding:"5px 12px"}}>{item.price}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        );
    }
}

export default Cart;