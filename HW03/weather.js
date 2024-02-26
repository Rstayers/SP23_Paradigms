function toCelsius() {
    // grabs the input from the user
    let input = document.getElementById("temperature").value;
    
    // Check if the input is a valid number
    if (isNaN(input)) {
        // If not a number, display error message
        document.getElementById("result-parent").innerHTML = "<span id='result'><strong>Please input a valid number!</strong> </span>";
	document.getElementById("result").style.color = "red";
    } else {
        // If input is a number, perform the conversion
        // converts the temperature to Celsius
        let celsius = (input - 32) * 5 / 9;
	document.getElementById("result-parent").innerHTML = "The Temperature in Celsius is <span id='result'></span>";
        document.getElementById("result").style.color = "black";
        // show back to the user, on the <span> element
        document.getElementById("result").innerText = celsius;

    }
    
    // makes the div visible
    document.getElementById("result-parent").style.visibility = "visible";
}


