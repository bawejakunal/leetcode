char* reverseString(char* s) {
    int i;
    char temp;
    int length = strlen(s); //''\0' terminated string
    for (i = 0; i < length/2 ;i++)
    {
        temp = s[i];
        s[i] = s[length-1-i];
        s[length-1-i] = temp;
    }
    
    return s;
}