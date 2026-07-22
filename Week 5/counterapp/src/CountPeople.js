import React from "react";

class CountPeople extends React.Component{

    constructor(){
        super();

        this.state={
            entrycount:0,
            exitcount:0
        };
    }

    updateEntry=()=>{
        this.setState((prevState)=>({
            entrycount:prevState.entrycount+1
        }));
    }

    updateExit=()=>{
        this.setState((prevState)=>({
            exitcount:prevState.exitcount+1
        }));
    }

    render(){
        return(
            <div
                style={{
                    display:"flex",
                    justifyContent:"space-around",
                    marginTop:"200px"
                }}
            >

                <div>
                    <button
                        onClick={this.updateEntry}
                        style={{
                            backgroundColor:"lightgreen"
                        }}
                    >
                        Login
                    </button>

                    {" "}
                    {this.state.entrycount} People Entered!!
                </div>

                <div>
                    <button
                        onClick={this.updateExit}
                        style={{
                            backgroundColor:"lightgreen"
                        }}
                    >
                        Exit
                    </button>

                    {" "}
                    {this.state.exitcount} People Left!!
                </div>

            </div>
        );
    }

}

export default CountPeople;