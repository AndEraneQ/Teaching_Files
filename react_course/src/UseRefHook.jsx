import React, {useState, useEffect,useRef} from "react";

function UseRefHook(){

    let [number,setNumber] = useState(0);

    const inputRef = useRef(null);

    const inputRef1 = useRef(null);


    const inputRef2 = useRef(null);


    useEffect(() => {
        console.log("COMONENT RENDERED");
        console.log(inputRef);
    });

    function handleClick(){
        //setNumber(prevNumber => prevNumber + 1);
        if (inputRef.current) {
            inputRef.current.focus();
            inputRef.current.style.backgroundColor = "yellow";
            inputRef1.current.style.backgroundColor = "";
            inputRef2.current.style.backgroundColor = "";

        }
    }

    function handleClick1(){
        //setNumber(prevNumber => prevNumber + 1);
        if (inputRef1.current) {
            inputRef1.current.focus();
            inputRef1.current.style.backgroundColor = "yellow";
        
            inputRef.current.style.backgroundColor = "";
            inputRef2.current.style.backgroundColor = "";

        }
    }

    function handleClick2(){
        //setNumber(prevNumber => prevNumber + 1);
        if (inputRef2.current) {
            inputRef2.current.focus();
            inputRef2.current.style.backgroundColor = "yellow";
        
            inputRef1.current.style.backgroundColor = "";
            inputRef.current.style.backgroundColor = "";

        }
    }

    return(
        <div>
            <button onClick={handleClick}>click me</button>
            <input ref={inputRef} />

            <button onClick={handleClick1}>click me1</button>
            <input ref={inputRef1} />

            <button onClick={handleClick2}>click me2</button>
            <input ref={inputRef2} />
        </div>
    );
}

export default UseRefHook;