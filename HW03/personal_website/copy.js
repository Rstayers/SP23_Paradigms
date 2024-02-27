function copy()
{
    const element = document.querySelector('#email');
    console.log(element)
  // Create a fake `textarea` and set the contents to the text
  // you want to copy
  const storage = document.createElement('textarea');
  storage.value = element.innerText;
  element.appendChild(storage);

  // Copy the text in the fake `textarea` and remove the `textarea`
  storage.select();
  storage.setSelectionRange(0, 99999);
  document.execCommand('copy');
  element.removeChild(storage);
  alert("Email copied to clipboard!")

}