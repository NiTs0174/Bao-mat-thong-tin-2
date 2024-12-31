using System;
using System.IO;
using System.Security.Cryptography;
using System.Text;

public class AES
{
    private byte[] key;
    private byte[] iv;

    public AES()
    {
        // Khởi tạo key và iv (Initialization Vector)
        key = Encoding.UTF8.GetBytes("1234567890123456"); // Key phải có độ dài 16, 24 hoặc 32 bytes (128, 192 hoặc 256 bits)
        iv = Encoding.UTF8.GetBytes("abcdefghijklmnop"); // IV phải có độ dài 16 bytes
    }

    public string MaHoa(string plainText)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            aes.Key = key;
            aes.IV = iv;

            // Mã hóa dữ liệu
            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);
            using (MemoryStream memoryStream = new MemoryStream())
            {
                using (CryptoStream cryptoStream = new CryptoStream(memoryStream, encryptor, CryptoStreamMode.Write))
                {
                    using (StreamWriter streamWriter = new StreamWriter(cryptoStream))
                    {
                        streamWriter.Write(plainText);
                    }
                }
                return Convert.ToBase64String(memoryStream.ToArray());
            }
        }
    }

    public string GiaiMa(string encryptedText)
    {
        using (AesCryptoServiceProvider aes = new AesCryptoServiceProvider())
        {
            aes.Key = key;
            aes.IV = iv;

            // Giải mã dữ liệu
            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);
            using (MemoryStream memoryStream = new MemoryStream(Convert.FromBase64String(encryptedText)))
            {
                using (CryptoStream cryptoStream = new CryptoStream(memoryStream, decryptor, CryptoStreamMode.Read))
                {
                    using (StreamReader streamReader = new StreamReader(cryptoStream))
                    {
                        return streamReader.ReadToEnd();
                    }
                }
            }
        }
    }
}
