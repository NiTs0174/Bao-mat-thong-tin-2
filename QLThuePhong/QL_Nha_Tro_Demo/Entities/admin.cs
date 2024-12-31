namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("admin")]
    public partial class admin
    {
        [Key]
        public int acc { get; set; }

        [Required]
        [StringLength(50)]
        public string taikhoan { get; set; }

        public string matkhau { get; set; }

        public int? role { get; set; }
    }
}
