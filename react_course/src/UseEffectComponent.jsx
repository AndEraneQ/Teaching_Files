import React, {useState, useEffect} from "react";

function UseEffectComponent(){

    // const [count, setCount] = useState(0);
    // const [color, setColor] = useState("green");

    // useEffect(() => {
    //     document.title = `Count: ${count} ${color}`;
    // },[count,color]);

    // function addCount(){
    //     setCount(c => c+1);
    // }

    // function subtractCount(){
    //     setCount(c => c-1);
    // }

    // function changeColor(){
    //     setColor(c => c === "green" ? "red" : "green");
    // }

    // return(
    //     <div>
    //         <p style={{color: color}}> Count: {count}</p>
    //         <button onClick={addCount}>Add</button>
    //         <button onClick={subtractCount}>Subtract</button><br/>
    //         <button onClick={changeColor}>Change color</button>
    //     </div>
    // );

    const [width, setWidth] = useState(window.innerWidth);
    const [height, setHeight] = useState(window.innerHeight);

    useEffect(() => {
        window.addEventListener("resize",handleResize);
        console.log("EVENT LISTENER ADDED")

        return () => {
            window.removeEventListener("resize",handleResize);
            console.log("EVENT LISTENER REMOVED")
        }
    }, []);
   
    function handleResize(){
        setWidth(window.innerWidth);
        setHeight(window.innerHeight)
    }

    useEffect(() => {
        document.title = `size: ${width} ${height}`;
    });

    return(
        <>
        <p>Width: {width}px</p>
        <p>Height: {height} px</p>
        </>
    );
}

export default UseEffectComponent;