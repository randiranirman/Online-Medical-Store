export  const openEditModel =  ( username , name , email , company , address) => {
    document.getElementById("originalUsername" ).value= username;
    document.getElementById("editUsername").value= username;


    document.getElementById("editName").value= name;
    document.getElementById('editEmail').value = email;
    document.getElementById('editCompany').value = company;
    document.getElementById('editAddress').value = address;

    document.getElementById('editModal').classList.remove('hidden');
    document.getElementById('overlay').classList.remove('hidden');





}

export  const closeEditModel =( ) => {
    document.getElementById('editModal').classList.add('hidden');
    document.getElementById('overlay').classList.add('hidden');
}