import Card from "./Card";
import Button from "./Button/Button";
import Student from "./Student";
import UserGreeting from "./UserGreeting";
import List from "./List";
import ButtonOnClick from "./ButtonOnClick";
import ProfilePicture from "./ProfilePicture";
import MyComponent from "./MyComponent";
import Counter from "./Counter";
import OnChange from "./OnChange";
import ColorPicker from "./ColorPicker";
import UpdateState from "./UpdateState";
import UpdateArrayInState from "./UpdateArrayInState";
import UpdateArrayOfObject from "./UpdateArraysOfObject";
import ToDoApp from "./ToDoApp";
import UseEffectComponent from "./UseEffectComponent";
import DigitalClock from "./DigitalClock";
import ComponentA from "./UseContext/ComponentA";
import UseRefHook from "./UseRefHook";
function App() {

  // const fruits = [{id: 1, name: "orange", calories: 95},
  //                 {id: 2, name: "banana", calories: 75},
  //                 {id: 3, name: "apple", calories: 14},
  //                 {id: 4, name: "coconout", calories: 9},
  //                 {id: 5, name: "pineapple", calories: 123}];
  
  // const wegetables = [{id: 6, name: "potatos", calories: 101},
  //                 {id: 7, name: "celary", calories: 71},
  //                 {id: 8, name: "carrots", calories: 54},
  //                 {id: 9, name: "corn", calories: 69},
  //                 {id: 10, name: "broccoli", calories: 13}];
                    


  
  return(
    <>
    {/* fruits.length > 0 && <List items={fruits} category="Fruits"/>} */}
    {/* {wegetables.length > 0 && <List items={wegetables} category="Wegetables"/>} */}
    {/* <ButtonOnClick/> */}
    {/* <ProfilePicture></ProfilePicture> */}
    {/* <MyComponent/> */}
    {/* <Counter></Counter> */}
    {/* <OnChange></OnChange> */}
    {/* <ColorPicker></ColorPicker> */}
    {/* <UpdateState/> */}
    {/* <UpdateArrayInState/> */}
    {/* <UpdateArrayOfObject/> */}
    {/* <ToDoApp/> */}
    {/* <UseEffectComponent/> */}
    {/* <DigitalClock/> */}
    {/* <ComponentA/> */}
    <UseRefHook/>
    </>
  );
}

export default App
