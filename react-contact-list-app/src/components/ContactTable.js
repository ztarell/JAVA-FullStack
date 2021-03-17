import React from 'react';
import { Table, Button } from 'react-bootstrap'

  const ContactTableHeader = () => {
      return (
          <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Company</th>
              <th>Phone</th>
              <th>Email</th>
              <th></th>
              <th></th>
          </tr>
      );
  }

  const ContactRow = ({ contact , toggleEdit, toggleDelete }) => {
      return (
          <tr>
              <td>{contact.contactId}</td>
              <td>{contact.firstName}</td>
              <td>{contact.lastName}</td>
              <td>{contact.company}</td>
              <td>{contact.phone}</td>
              <td>{contact.email}</td>
              <td><Button onClick={toggleEdit} value={contact.contactId}>Edit</Button></td>
              <td><Button onClick={toggleDelete} value={contact.contactId}>Delete</Button></td>
          </tr>
      );
  }

  class ContactTable extends React.Component {

      static defaultProps = {
          contacts: [
              {
                  "contactId": 1,
                  "firstName": "Fake",
                  "lastName": "Contact",
                  "company": "Unknown Industries",
                  "phone": "000-0000",
                  "email": "fContact@unknowninc.io"
              },
              {
                  "contactId": 2,
                  "firstName": "Mystery",
                  "lastName": "Contact",
                  "company": "Unknown Industries",
                  "phone": "000-0000",
                  "email": "mContact@unknowninc.io"
              }
          ]
      }

      render() {
          return (<Table striped bordered hover>
              <thead>
                  <ContactTableHeader/>
              </thead>
              <tbody>
                  {this.props.contacts.map((contact, i) => {
                      return <ContactRow contact={contact} key={i}
                          toggleEdit={this.props.handleEdit}
                          toggleDelete={this.props.handleDelete}/>
                  })}
              </tbody>
          </Table>)
      }
  }

  export default ContactTable