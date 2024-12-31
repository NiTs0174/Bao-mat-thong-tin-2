using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace QL_Nha_Tro_Demo
{
    public partial class TimKiemKH : Form
    {

        SqlConnection conn = new SqlConnection("data source=TN\\MINHTHANG;initial catalog=QLKSEZ;integrated security=True");
        SqlCommand cmd;
        SqlDataAdapter adapter;

        public void xoatrang()
        {
            searchboxkey.Text = "";
        }

        public TimKiemKH()
        {
            InitializeComponent();
        }

        private void TimKiemKHPage_Load(object sender, EventArgs e)
        {
            searchboxhow.Text = "Tất cả";
        }

        private void searchexit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void searchbtn_Click(object sender, EventArgs e)
        {
            conn.Open();
            if (searchboxhow.Text == "Tất cả")
            {
                cmd = new SqlCommand("select * from KhachHang", conn);
                adapter = new SqlDataAdapter(cmd);

                DataTable dataTable = new DataTable();
                adapter.Fill(dataTable);

                dataGridViewsearchkh.DataSource = dataTable;
            }

            if (searchboxhow.Text == "Tên khách hàng")
            {
                cmd = new SqlCommand("select * from KhachHang where tenKH LIKE N'%" + searchboxkey.Text.Trim() + "%'", conn);
                adapter = new SqlDataAdapter(cmd);

                DataTable dataTable = new DataTable();
                adapter.Fill(dataTable);

                dataGridViewsearchkh.DataSource = dataTable;
                MessageBox.Show("Tìm kiếm tên khách hàng thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            if (searchboxhow.Text == "Địa chỉ")
            {
                cmd = new SqlCommand("select * from KhachHang where diaChi LIKE N'%" + searchboxkey.Text.Trim() + "%'", conn);
                adapter = new SqlDataAdapter(cmd);

                DataTable dataTable = new DataTable();
                adapter.Fill(dataTable);

                dataGridViewsearchkh.DataSource = dataTable;
                MessageBox.Show("Tìm kiếm địa chỉ khách hàng thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            if (searchboxhow.Text == "Số điện thoại")
            {
                cmd = new SqlCommand("select * from KhachHang where soDTKH LIKE N'%" + searchboxkey.Text.Trim() + "%'", conn);
                adapter = new SqlDataAdapter(cmd);

                DataTable dataTable = new DataTable();
                adapter.Fill(dataTable);

                dataGridViewsearchkh.DataSource = dataTable;
                MessageBox.Show("Tìm kiếm số điện thoại khách hàng thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

            conn.Close();
        }

        private void searchclear_Click(object sender, EventArgs e)
        {
            if (searchboxkey.Text == null)
            {
                MessageBox.Show("Không có ký tự để xóa", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                searchboxhow.Focus();
            } 
            else
            {
                xoatrang();
            }
        }
    }
}
